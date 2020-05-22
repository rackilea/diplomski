$sql="
    INSERT INTO `mobile_App`
    (
        `First_Name`,
        `Last_Name`,
        `Phone`,
        `Mail_ID`,
        `Password`,
        `La`,
        `Lo`,
        `Ac`,
        `Pro`
    )
    VALUES (
        '".$First_Name."',
        '".$Last_Name."',
        $Phone,
        '".$Mail_ID."',
        '".$Password."',
        $La,
        $Lo,
        $Ac,
        '".$Pro."'
    )
;";