<template name="auth" value="@author $USER$ &#10;    * @since  $DATE$&#10;    *" description="Inset Javadoc @author and @since tags" toReformat="true" toShortenFQNames="true">
  <variable name="USER" expression="user()" defaultValue="" alwaysStopAt="false" />
  <variable name="DATE" expression="date()" defaultValue="" alwaysStopAt="false" />
  <context>
    <option name="JAVA_COMMENT" value="true" />
  </context>
</template>