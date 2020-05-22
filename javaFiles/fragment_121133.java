public class FiltrationModePopup extends Popup implements AfterCompose, IdSpace {
        private Radiogroup rgScrollerMode;

        @Override
        public void afterCompose() {
            rgScrollerMode = (Radiogroup) getFellow("rgScrollerMode");
            final Button okButton = (Button) getFellow("okButton");
            okButton.addEventListener(Events.ON_CLICK, new SerializableEventListener<Event>() {
                @Override
                public void onEvent(Event event) {
                    System.out.println(rgScrollerMode.getSelectedIndex());
                    close();
                }
            });
            addForward(Events.ON_OK, okButton, Events.ON_CLICK);
        }
    }