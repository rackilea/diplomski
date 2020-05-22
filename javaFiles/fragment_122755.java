else if(direction == 0) {
            cursor = cursor.getParent();
            if(cursor!=null && cursor.getRight() != null)
                direction = 1;
            else
                direction = 0;
        }