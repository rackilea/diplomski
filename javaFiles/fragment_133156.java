foreach ($dataArr as $direct) {
    // create a few references to reduce "ugly" code
    $counter      = &$arrayToBeFilled[$direct['DS']['DATE']][$direct['DLI']['LIID']]['COUNTER_TOTALIMPR'];
    $directStatus = &self::$orderLineitemSetting[$direct['DOX']['ORDID']][$direct['DLI']['LIID']]['setting']['is_direct'];
    $ronStatus    = &self::$orderLineitemSetting[$direct['DOX']['ORDID']][$direct['DLI']['LIID']]['setting']['is_ron'];

    $dfpAdUnit = $direct['AD1']['DFPAD1'].'/'.$direct['AD2']['DFPAD2'];

    if (!isset($counter)) {
        $counter = 0;
    }

    $counter += $direct[0]['DFPIMPR'];

    $e = array(
        'DATE'       => $direct['DS']['DATE'],
        'ISADEX'     => 0,
        'ISMM'       => 0,
        'ADVERTISER' => $direct['DA']['ADVERTISER'],
        'ORDID'      => $direct['DOX']['ORDID'],
        'ORDNAME'    => $direct['DOX']['ORDNAME'],
        'LINAME'     => $direct['DLI']['LINAME'],
        'LIID'       => $direct['DLI']['LIID'],
        'LISIZE'     => $direct['DSZ']['LISIZE'],
        'SITEID'     => $direct['PUBSITE']['SITEID'],
        'COUNTRYID'  => $direct['DC']['COUNTRYID'],
        'COUNTRY'    => $direct['DC']['COUNTRY'],
        'DFPADUNIT'  => $dfpAdUnit,
        'TP'         => '',
        'TPTAGID'    => 0
    );

    $e['ISDIRECT'] = !isset($directStatus) ? 1 : $directStatus;
    $e['ISRON']    = !isset($ronStatus) ? 0 : $ronStatus;

    if (isset($directStatus) && $directStatus === 2) { // Hint: don't use magic numbers (2),
                                                       // create some constant with appropriate name
        $e += array(
            'PBIMPR'   => $direct[0]['DFPIMPR'],
            'DFPIMPR'  => $direct[0]['DFPIMPR'],
            'DFPCLCKS' => $direct[0]['DFPCLCKS'],
            'DFPREV'   => 0,
            'TPIMPR'   => 0,
            'TPCLCKS'  => 0,
            'TPREV'    => 0
        );
    } else {
        $e += array(
            'DFPIMPR'  => $direct[0]['DFPIMPR'],
            'DFPCLCKS' => $direct[0]['DFPCLCKS'],
            'DFPREV'   => $direct[0]['DFPREV'],
            'TPIMPR'   => $direct[0]['DFPIMPR'],
            'TPCLCKS'  => $direct[0]['DFPCLCKS'],
            'TPREV'    => $direct[0]['DFPREV']
        );
    }

    $arrayToBeFilled[$direct['DS']['DATE']][$direct['DLI']['LIID']][$dfpAdUnit][$direct['DC']['COUNTRYID']] = $e;
}