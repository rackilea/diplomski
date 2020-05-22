@Grab( 'commons-lang:commons-lang:2.6' )
import org.apache.commons.lang.StringEscapeUtils as SEU

def str = 'G&#233;n&#233;ralit&#233;s'

println SEU.unescapeHtml( str )