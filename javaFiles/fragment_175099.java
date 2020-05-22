Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(10), evt -> {

        nameLvl.setText(list.get(count).getName());
        rollLvl.setText("Roll: " + list.get(count).getRoll());
        batchLvl.setText("Batch: " + list.get(count).getBatch());
        depLvl.setText("Department: " + list.get(count).getDepartment());
        uniLvl.setText(list.get(count).getUniversity());
        circle.setFill(new ImagePattern(new Image(list.get(count).getImagePath())));

        fd.play();
        rt.play();
        tm.play();

        count++;
        if (count >= list.size())
            count = 0;
        }
    });

}));
timeline.setCycleCount(Animation.INDEFINITE);

timeline.play();