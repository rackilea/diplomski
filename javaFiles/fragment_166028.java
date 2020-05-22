<?php

while ($row = mysql_fetch_array($req)) {
  $out[] = preg_replace_callback("/\\\\u([a-f0-9]{4})/i", "unescape", $row);
}

// On PHP 5.4+ use json_encode($out, JSON_UNESCAPED_UNICODE)
echo json_encode($out);

/* Accept the matcher array
 * return the UTF-8 encoded string
 */
function unescape($match) {
  return call_user_func_array('pack', get_pack_args(hexdec($match[1])));
}

function get_pack_args($cp) {
  if ($cp < 0x80) return array('C1', $cp);

  if ($cp < 0x0800) {
    $length = 2;
  } else if ($cp < 0x010000) {
    $length = 3;
  } else {
    $length = 4;
  }

  $args[0] = "C{$length}";

  // lead byte
  $args[1] = (0xFE << (7 - $length)) | ($cp >> (6 * ($length - 1)));

  // continuation bytes
  for ($l = 0; $l < ($length - 1); $l++) {
    $args[$length - $l] = 0x80 | (($cp >> (6 * $l)) & 0x3F);
  }

  // stupid PHP...
  ksort($args);
  return $args;
}