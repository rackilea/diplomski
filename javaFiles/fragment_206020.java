function generateChartData() {
            var chartData = [];
            var xAxis;
            var yAxis1;
            var yAxis2;
            var yAxis3;
            var yAxis4;
            var yAxis5;

                @if(totalAmountForms==1){
                    @for(i <- 0 until data.get(0).length) {
                        xAxis = @label.get(0).get(i)
                        yAxis1 = @data.get(0).get(i)

                    chartData.push({
                        values1: yAxis1,
                        categories: xAxis
                });
                    }
                }
                @if(totalAmountForms==2){
                    @for(i <- 0 until data.get(1).length) {
                        xAxis = @label.get(0).get(i)
                        yAxis1 = @data.get(0).get(i)
                        yAxis2 = @data.get(1).get(i)

                    chartData.push({
                        values1: yAxis1,
                        values2: yAxis2,
                        categories: xAxis
                });
                    }
                }
                @if(totalAmountForms==3){
                    @for(i <- 0 until data.get(2).length) {
                        xAxis = @label.get(0).get(i)
                        yAxis1 = @data.get(0).get(i)
                        yAxis2 = @data.get(1).get(i)
                        yAxis3 = @data.get(2).get(i)

                    chartData.push({
                        values1: yAxis1,
                        values2: yAxis2,
                        values3: yAxis3,
                        categories: xAxis
                });
                    }
                }
                @if(totalAmountForms==4){
                    @for(i <- 0 until data.get(3).length) {
                        xAxis = @label.get(0).get(i)
                        yAxis1 = @data.get(0).get(i)
                        yAxis2 = @data.get(1).get(i)
                        yAxis3 = @data.get(2).get(i)
                        yAxis4 = @data.get(3).get(i)

                    chartData.push({
                        values1: yAxis1,
                        values2: yAxis2,
                        values3: yAxis3,
                        values4: yAxis4,
                        categories: xAxis
                });
                    }
                }
                @if(totalAmountForms==5){
                    @for(i <- 0 until data.get(4).length) {
                        xAxis = @label.get(0).get(i)
                        yAxis1 = @data.get(0).get(i)
                        yAxis2 = @data.get(1).get(i)
                        yAxis3 = @data.get(2).get(i)
                        yAxis4 = @data.get(3).get(i)
                        yAxis5 = @data.get(4).get(i)

                    chartData.push({
                        values1: yAxis1,
                        values2: yAxis2,
                        values3: yAxis3,
                        values4: yAxis4,
                        values5: yAxis5,
                        categories: xAxis
                });
                    }
                }
            return chartData;  
            }