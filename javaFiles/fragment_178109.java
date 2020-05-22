<junitreport>
<fileset dir="${testReport.dir}/tmp">
      <include name="*.xml" />
</fileset>
<report format="frames" styledir="${testReportXslt.dir}" todir="${finalReport.dir}/html" />
</junitreport>