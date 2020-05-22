<!-- Page's own locale (you should already have that part). -->
<fmt:setLocale value="${user.locale}" />
<fmt:setBundle ... />

... text ...

<!-- Temporarily set to English, format number and then set back to page locale. -->
<fmt:setLocale value="en_US" />
<fmt:formatNumber ... />
<fmt:setLocale value="${user.locale}" />