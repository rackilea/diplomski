for (Node n : lineChart.getChildrenUnmodifiable())
        {
            if (n instanceof Legend)
            {
                final Legend legend = (Legend) n;

                // remove the legend
                legend.getChildrenUnmodifiable().addListener(new ListChangeListener<Object>()
                {
                    @Override
                    public void onChanged(Change<?> arg0)
                    {
                        for (Node node : legend.getChildrenUnmodifiable())
                        {
                            if (node instanceof Label)
                            {
                                final Label label = (Label) node;
                                label.getChildrenUnmodifiable().addListener(new ListChangeListener<Object>()
                                {
                                    @Override
                                    public void onChanged(Change<?> arg0)
                                    {
                                        //make style changes here
                                    }

                                });
                            }
                        }
                    }
                });
            }
        }