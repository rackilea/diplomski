public class Demo {

    public static void main(String[] args) {

        // Create some sample data
        double[] x = new double[100]; x[0] = 1;
        double[] y1 = new double[100]; y1[0] = 200;
        double[] y2 = new double[100]; y2[0] = 300;
        for(int i = 1; i < x.length; i++){
            x[i] = i+1; 
            y1[i] = y1[i-1] + Math.random()*10 - 4;
            y2[i] = y2[i-1] + Math.random()*10 - 6;
        }

        // JAVA:                             // MATLAB:
        MatlabChart fig = new MatlabChart(); // figure('Position',[100 100 640 480]);
        fig.plot(x, y1, "-r", 2.0f, "AAPL"); // plot(x,y1,'-r','LineWidth',2);
        fig.plot(x, y2, ":k", 3.0f, "BAC");  // plot(x,y2,':k','LineWidth',3);
        fig.RenderPlot();                    // First render plot before modifying
        fig.title("Stock 1 vs. Stock 2");    // title('Stock 1 vs. Stock 2');
        fig.xlim(10, 100);                   // xlim([10 100]);
        fig.ylim(200, 300);                  // ylim([200 300]);
        fig.xlabel("Days");                  // xlabel('Days');
        fig.ylabel("Price");                 // ylabel('Price');
        fig.grid("on","on");                 // grid on;
        fig.legend("northeast");             // legend('AAPL','BAC','Location','northeast')
        fig.font("Helvetica",15);            // .. 'FontName','Helvetica','FontSize',15
        fig.saveas("MyPlot.jpeg",640,480);   // saveas(gcf,'MyPlot','jpeg');
    }
}