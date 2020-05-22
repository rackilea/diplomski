<?php
class Hero {
            // Creating some properties
            public $name;
            public $about;
            public $image;

            // Assigning the values
            public function __construct($name, $about, $image) {
              $this->name = $name;
              $this->about = $about;
              $this->image = $image;
            }
}

$array_heros[0] = new Hero('Spiderman', 'Spiderman-about', 'image_link');
$array_heros[1] = new Hero('Batman', 'Batman-about', 'image_link');
$json2  = array(
  "error" => "false",
  "Heroes" => $array_heros
);

echo json_encode($json2);
 ?>