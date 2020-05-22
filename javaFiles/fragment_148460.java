public class LatinKeyboard extends Keyboard {
         /**
         * This looks at the ime options given by the current editor, to set the
         * appropriate label on the keyboard's enter key (if it has one).
         */
        void setImeOptions(Resources res, int options) {

            switch (options&(EditorInfo.IME_MASK_ACTION|EditorInfo.IME_FLAG_NO_ENTER_ACTION)) {
                case EditorInfo.IME_ACTION_GO:
                   //Action GO
                   break;
                case EditorInfo.IME_ACTION_NEXT:
                   //Action Next
                   break;
                case EditorInfo.IME_ACTION_SEARCH:
                    //Action Search
                    break;
                case EditorInfo.IME_ACTION_SEND:
                    //Action SEND
                    break;
                default:
                    //Action Default
                    break;
            }
        }
}