$data = array(
    'err' => 0,
    'msg' => "",
    'data' => array(),
);

$mysqli = new MySQLi($dbhost,$dbuser,$dbpass,$dbname);
if($mysqli->connect_errno){
    $data['err'] = 1;
    $data['msg'] = "Brak polaczenia z baza";
    exit(json_encode($data));
}

if(isset($_GET['login']) && isset($_GET['pass'])){
    $mysqli->query("SET CHARACTER SET 'utf8';");
    $query = $mysqli->query("SELECT banned.id_user FROM banned JOIN user ON user.id_user = banned.id_user WHERE user.login ='{$_GET['login']}' LIMIT 1;");
    if($query->num_rows){
        $data['err']=1;
        $data['msg']="User banned";
        exit(json_encode($data));
    }else{
        $query = $mysqli->query("SELECT login FROM user WHERE login='{$_GET['login']}' LIMIT 1;");
        if($query->num_rows){
            $query = $mysqli->query("SELECT pass FROM user WHERE pass ='{$_GET['pass']}' LIMIT 1;");
            if($query->num_rows){
                $data['msg']="Logged IN!";
                $query = $mysqli->query("SELECT id_user FROM user WHERE login='{$_GET['login']}' LIMIT 1;");
                $data['data'][]=$query->fetch_assoc();
                exit(json_encode($data));
            }else{
                $data['err']=1;
                $data['msg']="Wrong login credentials.";
                exit(json_encode($data));
            }
        }else{
            $data['err']=1;
            $data['msg']="This login doesn't exist.";
            exit(json_encode($data));
        }
    }
}else{
    $data['err']=1;
    $data['msg']="Wrong login credentials";
    exit(json_encode($data));
}