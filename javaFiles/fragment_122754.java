else if(direction == 0) {
            cursor = cursor.getParent();
            if(cursor.getRight() != null)
                direction = 1;
            else
                direction = 0;
        }