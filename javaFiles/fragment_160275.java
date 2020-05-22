if($query->num_rows){
        while($res=$query->fetch_assoc()){
            $data['data'][]=$res;
        }
        exit(json_encode($data));
}