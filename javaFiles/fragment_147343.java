//                                                     here you place quantifier
//                                                                ↓
if (pw.matches("[A-Za-z0-9!\"#$%&'()*+,.\\/:;<=>?@[\\]^_`{|}~-]+$]+")){
     System.out.println("password contains only valid characters");
} else {
     System.out.println("invalid characters in password");
}