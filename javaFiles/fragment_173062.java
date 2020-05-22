<target name="test">
  <!-- value="..." is the value to use if the condition is true,
       else="..." is the value to use if the condition is false -->
  <condition property="compiler.arch" value="x86_64" else="i386">
    <equals arg1="${bits}" args2="64" />
  </condition>

  <!-- use ${compiler.arch} here -->
</target>