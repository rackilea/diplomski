// Set the maximum number of nested levels required.
int max = 50;
String regex = "(?R)";

while (--max > 0) {
    regex = regex.replace("(?R)", "(?>\\{(?:[^{}]*+|(?R))+\\})");
}

// Ensure no (?R) in the final and deepest replacement.
regex = regex.replace("(?R)", "\\{[^{}]*+\\}") + "|\\w+";

String str = " {{}{}} {abc} {{de}{fg}} hij {1{2{3{4{5{6{7{8{9{10{11{12{13{14{15{16{17{18{19{20{21{22{23{24{25{26{27{28{29{30{31{32{33{34{35{36{37{38{39{40{41{42{43{44{45{46{47{48{49{50}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}} {end}";
Matcher m = Pattern.compile(regex).matcher(str);

while (m.find()) {
    System.out.println(m.group());
}

/*
 {{}{}}
 {abc}
 {{de}{fg}}
 hij
 {1{2{3{4{5{6{7{8{9{10{11{12{13{14{15{16{17{18{19{20{21{22{23{24{25{26{27{28{29{30{31{32{33{34{35{36{37{38{39{40{41{42{43{44{45{46{47{48{49{50}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}
 {end}
*/