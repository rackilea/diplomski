String VIETNAMESE_DIACRITIC_CHARACTERS 
        = "ÁÀÃẢẠĂẮẰẲẴẶÂẤẦẨẪẬĐÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒÕỎỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰÝỲỶỸỴ";

Pattern p =
    Pattern.compile("(?:[" + VIETNAMESE_DIACRITIC_CHARACTERS + "]|[A-Z])++",
                    Pattern.CANON_EQ |
                    Pattern.CASE_INSENSITIVE |
                    Pattern.UNICODE_CASE);