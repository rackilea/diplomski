String input = "zzz";

String email = "user.q@stackoverflow.com";

int at = email.indexOf('@');

String newEmail = email.substring(0, at) + input + email.substring(at);