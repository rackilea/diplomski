subjectPack.substring(message.getSubject().lastIndexOf("#")+1).toUpperCase();
//                        ^ you determine the starting position here
//  ^ you are extracting from this string

// "FW: Freight shifted on Turbana Load Po#160753"
// "FW Freight shifted on Turbana Load Po#160753"
//  you are extracting from ...            ^ this position