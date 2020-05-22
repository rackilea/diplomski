$reader = new XMLReader();
$reader->open(<path_to_large_xml_file>);    
while ($reader->read()) {
    switch ($reader->nodeType) {
        case (XMLREADER::ELEMENT):
        if ($reader->localName == "Table") {

            $node = $reader->expand();
            $dom = new DomDocument();
            $n = $dom->importNode($node,true);
            $dom->appendChild($n);
            $sxe = simplexml_import_dom($n);

            $Data = array();
            $DataColumns = array();

            foreach ($columns as $key => $column)
            {

                if (in_array($key,$DateColumns))
                {
                    $DateArray = explode('/',substr(trim($sxe->$column),0,10));   
                    $ValueColumn = date('Y-m-d H:i:s',mktime(0,0,0,$DateArray[1],$DateArray[0],$DateArray[2]));
                    $Data[] = '\''.$ValueColumn.'\'';
                    $DataColumns[] = $key;

                    if ($SplitDateInsert == 'enabled')
                    {
                        $Data[] = '\''.$DateArray[2].'\'';
                        $Data[] = '\''.$DateArray[1].'\'';
                        $Data[] = '\''.$DateArray[0].'\'';

                        $DataColumns[] = $key.'_year';
                        $DataColumns[] = $key.'_month';
                        $DataColumns[] = $key.'_day';                            
                    }

                } else {
                    $ValueColumn = addslashes(trim($sxe->$column));
                    $Data[] = '\''.$ValueColumn.'\'';
                    $DataColumns[] = $key;
                }                   

            }               
                $SQL = "INSERT INTO {$tableName} (".implode(',',$DataColumns).") VALUES (".implode(',',$Data).")";                  
                $db->query($SQL);                       

        } // END IF table
    }
}