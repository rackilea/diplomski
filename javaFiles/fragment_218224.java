$array = array(1, 2, 3, 4);
function modifyArray(&$data)
{
    unset($data[1]);
}
modifyArrax($array);
// $array = array(0 => 1, 2 => 3, 3 => 4)