/**
 * Dash Encoding:
 *
 * Zeta-Jones <=> Zeta--Jones
 * Blade - The Last Installment <=> Blade---The-Last-Installment
 * Wrongo -Weird => Wrongo---Weird (decodes to => Wrongo - Weird)
 * Wrongo- Weird => Wrongo---Weird (decodes to => Wrongo - Weird)
 */
function dashEncode($s) {
    static $pattern = array(
        'dashes' => "--+",     // "--" => "-"
        'blanks' => "\\s\\s+", // "   " => " "

        'hyphen' => "(?<=[^-\\s])-(?=[^-\\s])",  // like "Zeta-Jones"
        'dash'   => "[\\s]-[\\s]|-[\\s]|[\\s]-", // like "Blade - The Last Installment"
        'blank'  => "\\s+"
    );

    $matcher = function($name, $s, $with) use ($pattern) {
        isset($pattern[$name]) || die("pattern '$name' undefined."); 
        return preg_replace("~{$pattern[$name]}~", $with, $s);
    };

    $s = 
    $matcher('blank',
        $matcher('hyphen',
            $matcher('dash',
                $matcher('dashes',
                    $matcher('blanks', trim($s), " ") // compress embedded whitespace "   " => " "
                , "-") // trim and compress multiple dashes "---" => "-"
            , "---") // replace dash with surrounding white space => "---"
        , "--") // replace single "-" => "--"
    , "-"); // replace blanks with "-"$matcher('blanks', trim($s), " ");  // compress embedded whitespace "   " => " "
    return $s;
}