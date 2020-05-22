rs.append("$2");
if (minor >= 'a')
        rs.append(minor);
rs.append("$");
if (rounds < 10)
        rs.append("0");
rs.append(Integer.toString(rounds));
rs.append("$");
rs.append(encode_base64(saltb, saltb.length));
rs.append(encode_base64(hashed, bf_crypt_ciphertext.length * 4 - 1));
return rs.toString();