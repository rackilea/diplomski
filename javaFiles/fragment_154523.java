int score = 0;
            for (JRadioButton correctButton : correctButtons) {
                if (correctButton.isSelected()) {
                    ++score;
                }
            }