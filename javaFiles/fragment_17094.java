// \G\[(?:(?:name:(?<name>[^,\]]+)|quantity:(?<quantity>[^,\]]+)|unit_price:(?<unit_price>[^,\]]+)),?)*\](?:,|\z)
// 
// Options: Case insensitive; Exact spacing; Dot matches line breaks; ^$ don’t match at line breaks; Default line breaks
// 
// Assert position at the end of the previous match (the start of the string for the first attempt) «\G»
// Match the character “[” literally «\[»
// Match the regular expression below «(?:(?:name:(?<name>[^,\]]+)|quantity:(?<quantity>[^,\]]+)|unit_price:(?<unit_price>[^,\]]+)),?)*»
//    Between zero and unlimited times, as many times as possible, giving back as needed (greedy) «*»
//    Match the regular expression below «(?:name:(?<name>[^,\]]+)|quantity:(?<quantity>[^,\]]+)|unit_price:(?<unit_price>[^,\]]+))»
//       Match this alternative (attempting the next alternative only if this one fails) «name:(?<name>[^,\]]+)»
//          Match the character string “name:” literally (case insensitive) «name:»
//          Match the regex below and capture its match into a backreference named “name” (also backreference number 1) «(?<name>[^,\]]+)»
//             Match any single character NOT present in the list below «[^,\]]+»
//                Between one and unlimited times, as many times as possible, giving back as needed (greedy) «+»
//                The literal character “,” «,»
//                The literal character “]” «\]»
//       Or match this alternative (attempting the next alternative only if this one fails) «quantity:(?<quantity>[^,\]]+)»
//          Match the character string “quantity:” literally (case insensitive) «quantity:»
//          Match the regex below and capture its match into a backreference named “quantity” (also backreference number 2) «(?<quantity>[^,\]]+)»
//             Match any single character NOT present in the list below «[^,\]]+»
//                Between one and unlimited times, as many times as possible, giving back as needed (greedy) «+»
//                The literal character “,” «,»
//                The literal character “]” «\]»
//       Or match this alternative (the entire group fails if this one fails to match) «unit_price:(?<unit_price>[^,\]]+)»
//          Match the character string “unit_price:” literally (case insensitive) «unit_price:»
//          Match the regex below and capture its match into a backreference named “unit_price” (also backreference number 3) «(?<unit_price>[^,\]]+)»
//             Match any single character NOT present in the list below «[^,\]]+»
//                Between one and unlimited times, as many times as possible, giving back as needed (greedy) «+»
//                The literal character “,” «,»
//                The literal character “]” «\]»
//    Match the character “,” literally «,?»
//       Between zero and one times, as many times as possible, giving back as needed (greedy) «?»
// Match the character “]” literally «\]»
// Match the regular expression below «(?:,|\z)»
//    Match this alternative (attempting the next alternative only if this one fails) «,»
//       Match the character “,” literally «,»
//    Or match this alternative (the entire group fails if this one fails to match) «\z»
//       Assert position at the very end of the string «\z»