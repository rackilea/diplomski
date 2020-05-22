C:\>"\Program Files\Java\jdk-10\bin\jshell.exe"
|  Welcome to JShell -- Version 10
|  For an introduction type: /help intro

jshell> public class Butterfly {
   ...>
   ...> public static double dx(double x, double y, double z) {
   ...>     return -10*(x - y);

         [... many lines omitted for brevity ...]

   ...>     }
   ...>    }
   ...> }
|  created class Butterfly

jshell> Butterfly.main(new String[] {})
0.2, 19.98, 24.933333333333334
0.39780000000000004, 19.960633333333334, 24.870840444444443
0.5934283333333333, 19.9419174796712, 24.81245854319926
0.786913224796712, 19.92386713960567, 24.758126085937494

         [... many lines omitted for brevity ...]

0.381817425662861, 0.5879585365342771, 12.654916756967012
0.38387883677157514, 0.59322959817818, 12.621394805096582
0.3859723443856412, 0.5985398896533907, 12.587965480571079
0.3880980198383187, 0.6038899688589537, 12.554628592467306

jshell>