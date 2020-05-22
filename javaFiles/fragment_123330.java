#set ($VOID = $velocityPortletPreferences.setValue('portletSetupShowBorders', 'false'))
        #set ($portlet_id = '56')
        #set ($instance_id = "lw8tVGo0NyCB")
        #set ($my_portlet_id = "${portlet_id}_INSTANCE_${instance_id}")
        $theme.runtime($my_portlet_id, "", $velocityPortletPreferences.toString())
        $velocityPortletPreferences.reset() </footer>