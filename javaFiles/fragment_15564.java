--- orig    2015-11-20 14:23:05.221578051 +0100
+++ mod 2015-11-20 14:24:46.691333378 +0100
@@ -12,19 +12,20 @@

 public static void main(String[] args) 
 {
-    myFrame window = new myFrame();
-
     warior Tim = new warior();
     Tim.hp=100;
+
+    myFrame window = new myFrame(Tim);
+
 }

 }

 class myFrame extends JFrame
 {
-public myFrame()
+public myFrame(warior tim)
 {
-    myPanel panel = new myPanel();
+    myPanel panel = new myPanel(tim);
     Container cont = getContentPane();
     cont.add(panel);
     setBounds(0,0,1900,1000);
@@ -42,9 +43,12 @@
 private int x2=550,y2=300;
 private int n=1;
 private int n2=1;
+private final warior tim;

-public myPanel()
+public myPanel(warior tim)
 {
+    this.tim = tim;
+
     setFocusable(true);

         Timer nt = new Timer(1000,new ActionListener()
@@ -78,7 +82,7 @@
     gr.drawImage(gif1, x1, y1, null);
     gr.clearRect(x2, y2, gif2.getWidth(null), gif2.getHeight(null));
     gr.drawImage(gif2, x2, y2, null);
-    gr.fillRect(10, 800, 20, hp*20); //there is an error
+    gr.fillRect(10, 800, 20, tim.hp*20); //there is an error
 }
 }