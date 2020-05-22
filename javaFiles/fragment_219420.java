public String toString() {
#set ($autoImportPackages = "com.google.common.base.MoreObjects")
    return MoreObjects.toStringHelper(this)
#foreach ($member in $members)
    .add("$member.name", $member.accessor)
#end
    .toString();
}