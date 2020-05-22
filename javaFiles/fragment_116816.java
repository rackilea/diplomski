@@ -480,9 +481,10 @@ public class Settings extends PreferenceActivity implements ButtonBarHandler {

                     case HEADER_TYPE_NORMAL:
                         view = mInflater.inflate(
-                                com.android.internal.R.layout.preference_header_item, parent,
+                                R.layout.preference_header_switch_item, parent,
                                 false);
-                        holder.icon = (ImageView) view.findViewById(com.android.internal.R.id.icon);
+                        view.findViewById(R.id.switchWidget).setVisibility(View.GONE);
+                        holder.icon = (ImageView) view.findViewById(R.id.icon);
                         holder.title = (TextView)
                                 view.findViewById(com.android.internal.R.id.title);
                         holder.summary = (TextView)