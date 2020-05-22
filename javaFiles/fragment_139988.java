<?php

    function own_strlen($str) {
        $count = 0;
        while(@$str[$count] != "")
            $count++;
        return $count;
    }

    function removeNonNumericalCharacters($str) {
        $result = "";

        for($count = 0; $count < own_strlen($str); $count++) {
            $character = $str[$count];
            if((string)(int)$str[$count] === $character)
                $result .= $str[$count];
        }

        return $result;

    }

    $string  = "(123) 011 - 34343678";
    echo removeNonNumericalCharacters($string);

?>