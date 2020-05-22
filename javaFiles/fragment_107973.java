$arr = array();
$arr[] = new MyUSerDefinedObject("Hello");
//...

echo $arr[0]->methd();
//or
foreach ($arr as $val) {
    echo $val->methd();
}