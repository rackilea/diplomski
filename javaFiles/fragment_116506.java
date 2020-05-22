Code(max_stack = 1, max_locals = 1, code_length = 5)
0:    aload_0
1:    invokespecial java.lang.Object.<init>:()V (8)
4:    return

Attribute(s) = 
LineNumber(0, 10)
LocalVariable(start_pc = 0, length = 5, index = 0:de.scrum_master.stackoverflow.MethodDisassembler this)
Code(max_stack = 5, max_locals = 12, code_length = 165)
0:    ldc       de.scrum_master.stackoverflow.MethodDisassembler (1)
2:    astore_1
3:    new       <java.lang.StringBuilder> (19)
6:    dup
7:    aload_1
8:    invokevirtual java.lang.Class.getName:()Ljava/lang/String; (21)
11:   bipush        46
13:   bipush        47
15:   invokevirtual java.lang.String.replace:(CC)Ljava/lang/String; (27)
18:   invokestatic  java.lang.String.valueOf:(Ljava/lang/Object;)Ljava/lang/String; (33)
21:   invokespecial java.lang.StringBuilder.<init>:(Ljava/lang/String;)V (37)
24:   ldc       ".class" (40)
26:   invokevirtual java.lang.StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder; (42)
29:   invokevirtual java.lang.StringBuilder.toString:()Ljava/lang/String; (46)
32:   astore_2
33:   aconst_null
34:   astore_3
35:   aconst_null
36:   astore        %4
38:   aload_1
39:   invokevirtual java.lang.Class.getClassLoader:()Ljava/lang/ClassLoader; (49)
42:   aload_2
43:   invokevirtual java.lang.ClassLoader.getResourceAsStream:(Ljava/lang/String;)Ljava/io/InputStream; (53)
46:   astore        %5
48:   new       <org.apache.bcel.classfile.ClassParser> (59)
51:   dup
52:   aload     %5
54:   aload_2
55:   invokespecial org.apache.bcel.classfile.ClassParser.<init>:(Ljava/io/InputStream;Ljava/lang/String;)V (61)
58:   astore        %6
60:   aload     %6
62:   invokevirtual org.apache.bcel.classfile.ClassParser.parse:()Lorg/apache/bcel/classfile/JavaClass; (64)
65:   astore        %7
67:   aload     %7
69:   invokevirtual org.apache.bcel.classfile.JavaClass.getMethods:()[Lorg/apache/bcel/classfile/Method; (68)
72:   dup
73:   astore        %11
75:   arraylength
76:   istore        %10
78:   iconst_0
79:   istore        %9
81:   goto      #105
84:   aload     %11
86:   iload     %9
88:   aaload
89:   astore        %8
91:   getstatic     java.lang.System.out:Ljava/io/PrintStream; (74)
94:   aload     %8
96:   invokevirtual org.apache.bcel.classfile.Method.getCode:()Lorg/apache/bcel/classfile/Code; (80)
99:   invokevirtual java.io.PrintStream.println:(Ljava/lang/Object;)V (86)
102:  iinc      %9  1
105:  iload     %9
107:  iload     %10
109:  if_icmplt     #84
112:  aload     %5
114:  ifnull        #164
117:  aload     %5
119:  invokevirtual java.io.InputStream.close:()V (92)
122:  goto      #164
125:  astore_3
126:  aload     %5
128:  ifnull        #136
131:  aload     %5
133:  invokevirtual java.io.InputStream.close:()V (92)
136:  aload_3
137:  athrow
138:  astore        %4
140:  aload_3
141:  ifnonnull     #150
144:  aload     %4
146:  astore_3
147:  goto      #162
150:  aload_3
151:  aload     %4
153:  if_acmpeq     #162
156:  aload_3
157:  aload     %4
159:  invokevirtual java.lang.Throwable.addSuppressed:(Ljava/lang/Throwable;)V (97)
162:  aload_3
163:  athrow
164:  return

Exception handler(s) = 
From    To  Handler Type
48  112 125 <Any exception>(0)
38  138 138 <Any exception>(0)

Attribute(s) = 
LineNumber(0, 12), LineNumber(3, 13), LineNumber(33, 14), LineNumber(38, 14), 
LineNumber(48, 15), LineNumber(60, 16), LineNumber(67, 17), LineNumber(91, 18), 
LineNumber(102, 17), LineNumber(112, 19), LineNumber(164, 20)
LocalVariable(start_pc = 0, length = 165, index = 0:java.lang.String[] args)
LocalVariable(start_pc = 3, length = 162, index = 1:java.lang.Class clazz)
LocalVariable(start_pc = 33, length = 132, index = 2:java.lang.String classAsPath)
LocalVariable(start_pc = 48, length = 88, index = 5:java.io.InputStream classStream)
LocalVariable(start_pc = 60, length = 52, index = 6:org.apache.bcel.classfile.ClassParser classParser)
LocalVariable(start_pc = 67, length = 45, index = 7:org.apache.bcel.classfile.JavaClass javaClass)
LocalVariable(start_pc = 91, length = 11, index = 8:org.apache.bcel.classfile.Method method)
LocalVariableTypes(start_pc = 3, length = 162, index = 1:java.lang.Class<?>... clazz)
StackMap((FULL, offset delta=84, locals={(type=Object, class=[Ljava.lang.String;), (type=Object, class=java.lang.Class), (type=Object, class=java.lang.String), (type=Object, class=java.lang.Throwable), (type=Object, class=java.lang.Throwable), (type=Object, class=java.io.InputStream), (type=Object, class=org.apache.bcel.classfile.ClassParser), (type=Object, class=org.apache.bcel.classfile.JavaClass), (type=Bogus), (type=Integer), (type=Integer), (type=Object, class=[Lorg.apache.bcel.classfile.Method;)}), (SAME, offset delta=20), (FULL, offset delta=19, locals={(type=Object, class=[Ljava.lang.String;), (type=Object, class=java.lang.Class), (type=Object, class=java.lang.String), (type=Object, class=java.lang.Throwable), (type=Object, class=java.lang.Throwable), (type=Object, class=java.io.InputStream)}, stack items={(type=Object, class=java.lang.Throwable)}), (CHOP 1, offset delta=10), (SAME_LOCALS_1_STACK, offset delta=1, stack items={(type=Object, class=java.lang.Throwable)}), (SAME, offset delta=11), (SAME, offset delta=11), (CHOP 2, offset delta=1))
Code(max_stack = 1, max_locals = 1, code_length = 5)
0:    aload_0
1:    invokevirtual de.scrum_master.stackoverflow.MethodDisassembler.sendEmail:()V (124)
4:    return

Attribute(s) = 
LineNumber(0, 23), LineNumber(4, 24)
LocalVariable(start_pc = 0, length = 5, index = 0:de.scrum_master.stackoverflow.MethodDisassembler this)
Code(max_stack = 2, max_locals = 1, code_length = 9)
0:    getstatic     java.lang.System.out:Ljava/io/PrintStream; (74)
3:    ldc       "Sending e-mail" (127)
5:    invokevirtual java.io.PrintStream.println:(Ljava/lang/String;)V (129)
8:    return

Attribute(s) = 
LineNumber(0, 27), LineNumber(8, 28)
LocalVariable(start_pc = 0, length = 9, index = 0:de.scrum_master.stackoverflow.MethodDisassembler this)