if (sym >= 'a' && sym <= 'z') {
            low++;
        } else if (sym >= 'A' && sym <= 'Z') {
            up++;
        } else if (sym >= '0' && sym <= '9') {
            digit++;
        } else {
            other++;
        }