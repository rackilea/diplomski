Timeline hideAfter1sec = new Timeline(
            new KeyFrame(Duration.seconds(1), sec->{
                ((Label) selectedPane_1.Label.get(0)).setVisible(false);
                ((Label) selectedPane_2.Label.get(0)).setVisible(false);
            })
    );
    hideAfter1sec.playFromStart();