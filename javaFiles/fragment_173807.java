CursorJoiner joiner = new CursorJoiner(cursorA, keyColumnsofA, cursorB, keyColumnsofB);
 for (CursorJointer.Result joinerResult : joiner) {
     switch (joinerResult) {
         case LEFT:
             // handle case where a row in cursorA is unique
             break;
         case RIGHT:
             // handle case where a row in cursorB is unique
             break;
         case BOTH:
             // handle case where a row with the same key is in both cursors
             break;
     }
 }