public class MainMenu {
        private Scene scene;

        private final SoundPlayer soundPlayer ;

        private MainMenu(SoundPlayer soundPlayer) {

            this.soundPlayer = soundPlayer ;

            // existing code omitted...

            CheckBox soundOn = new CheckBox("soundOn?");
            Tooltip tooltip = new Tooltip("if this box is checked, music will be played!");
            tooltip.setFont(new Font("Arial", 16));
            soundOn.setTooltip(tooltip);
            soundOn.selectedProperty().addListener(new ChangeListener<Boolean>() {
                public void changed(ObservableValue<? extends Boolean> ov,
                                    Boolean old_val, Boolean new_val) {

                    soundPlayer.setSoundOn(new_val);
                }
            });

            // ...


            Slider soundVolume = new Slider(0, 1, .5);
            soundVolume.valueProperty().addListener(new ChangeListener<Number>() {
                public void changed(ObservableValue<? extends Number> ov,
                                    Number old_val, Number new_val) {

                    soundPlayer.setVolumn(new_val.doubleValue());
                    System.out.printf("%.2f\n", Main.soundVolume);
                }
            });
            changeVolumeWrapper.getChildren().add(soundVolume);
            vBox.getChildren().add(changeVolumeWrapper);
        }

        public Scene getScene() {
            return scene;
        }
    }

    public MainMenu getMainMenu() {
        return mainMenu;
    }
}