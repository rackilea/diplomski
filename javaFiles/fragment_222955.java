String VIETNAMESE_DIACRITIC_CHARACTERS 
        = "ẮẰẲẴẶĂẤẦẨẪẬÂÁÀÃẢẠĐẾỀỂỄỆÊÉÈẺẼẸÍÌỈĨỊỐỒỔỖỘÔỚỜỞỠỢƠÓÒÕỎỌỨỪỬỮỰƯÚÙỦŨỤÝỲỶỸỴ";

Pattern p =
    Pattern.compile("[A-Z" + VIETNAMESE_DIACRITIC_CHARACTERS + "]++",
                    Pattern.CANON_EQ |
                    Pattern.CASE_INSENSITIVE |
                    Pattern.UNICODE_CASE);