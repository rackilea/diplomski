**dataSets.add(createLineChart(company,company.StoreName,company.Total));**

                data = new LineData(column,dataSets);


                linechart.setData(data);
                linechart.invalidate();
                linechart.setDescription("Sales");