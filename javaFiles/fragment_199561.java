if (stringValue.length() > 60) {
            service028.setNote2(stringValue.substring(0, 60));
            service028.setNote3(stringValue.substring(60));
        } else {
            service028.setNote2(stringValue);
        }