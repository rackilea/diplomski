//Read one file at a time from a directory
               File folder = new File("C:\\MyDirectory");
               File[] listOfFiles = folder.listFiles();

            //initialize variables

                String infile, infileDate;
                double ratioCategoryA = 0;
                double ratioCategoryB = 0;
                double ratioCategoryC = 0;

                infileDate = "";

            //read one line at a time
                for (File file : listOfFiles) {
                if (file.isFile()) {

                infile = file.getName();
                //file name format - e.g., 08-09-2013.csv
                //extract date from file name to display on piechart
                int index = infile.indexOf("csv");
                infileDate = infile.substring(0, index-1);

                try{

                FileReader onefile = new FileReader(folder + "\\" +
                                 infile);
                BufferedReader reader = new BufferedReader(onefile);

                //initialize variables
                    String strLine;
                    int countCategoryA = 0;
                    int countCategoryB = 0;
                    int countCategoryC = 0;


            while ((strLine = reader.readLine()) != null) {

            //find category type in each line   
            if (strLine.contains("Category A")){
            countCategoryA = countCategoryA + 1;}
            if (strLine.contains("Category B")){
            countCategoryB = countCategoryB + 1;}
            if (strLine.contains("Category C")){
            countCategoryC = countCategoryC + 1;}


        }
        //calculate ratio for each event type
            int sum = countCategoryA + countCategoryB +    countCategoryC
            ratioCategoryA = (countCategoryA / (double)sum) * 100.0;
            ratioCategoryB = (countCategoryB / (double)sum) * 100.0;
            ratioCategoryC = (countCategoryC / (double)sum) * 100.0;

        onefile.close();
        }
        catch (Exception e){//Catch exception if any
        System.err.println("Error: " + e.getMessage());
        } 

        }

        // Create a simple pie chart
        DefaultPieDataset pieDataset = new DefaultPieDataset();

        pieDataset.setValue("Category A", new Double(ratioCategoryA));
        pieDataset.setValue("Category B", new Double(ratioCategoryB));
        pieDataset.setValue("Category C", new Double(ratioCategoryC));

    JFreeChart chart = ChartFactory.createPieChart
    ("Category Pie Chart " + infileDate, // Title
    pieDataset, // Dataset
    true, // Show legend
    true, // Use tooltips
    false // Configure chart to generate URLs?
    );

    PiePlot plot = (PiePlot) chart.getPlot();

        plot.setBackgroundPaint(Color.white);
        plot.setCircular(true);

        //generate percentage on each category type on the pie chart
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator(
            "{0} = {2}", NumberFormat.getNumberInstance(), NumberFormat.getPercentInstance()
        ));

        plot.setNoDataMessage("No data available");


    //save pie chart in jpg file

    try {
    ChartUtilities.saveChartAsJPEG(new File("C:\\chart" + infileDate + ".jpg"), chart, 500, 300);
    } catch (Exception e) {
    System.out.println("Problem occurred creating chart.");
    }
        } 
    }