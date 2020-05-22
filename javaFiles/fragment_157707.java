ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream projectInputStream = classloader.getResourceAsStream("jasper/xyLineChart.jasper");


        Map<String, Object> parameters = new HashMap<String, Object>();

        for(int i = 0 ; i< coordinatesList.size() ; i++){
            coordiantesListBean = new JRBeanCollectionDataSource(coordinatesList.get(i));
            parameters.put("XYChartDataSource", coordiantesListBean);
        }

        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(projectInputStream, parameters,
                    new JREmptyDataSource());
            JasperExportManager.exportReportToPdfFile(jasperPrint,FILE_LOCATION);
        } catch (JRException e) {
            e.printStackTrace();
        }