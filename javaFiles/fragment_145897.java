m_minSlider.textProperty().addListener(new ChangeListener()
        {

            @Override
            public void changed(ObservableValue arg0, Object arg1, Object arg2)
            {
                handleSlider();
            }
        });

        m_maxSlider.textProperty().addListener(new ChangeListener()
        {
            @Override
            public void changed(ObservableValue arg0, Object arg1, Object arg2)
            {
                handleSlider();
            }
        });