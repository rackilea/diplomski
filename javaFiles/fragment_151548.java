<?php
     $subject = "(city = 'pune' AND country = 'india') OR (division = 'it') AND (resource = 'someresource' )";
     $pattern = '/(\(.+?\))/';
     preg_match($pattern, $subject, $matches);
     print_r($matches);
?>