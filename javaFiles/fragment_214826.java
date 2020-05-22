ImageView appIcon = (ImageView)convertView.findViewById(R.id.item_app_icon);
            String packageName = apps.get(position).name.toString();

            try {
                Drawable icon = getPackageManager().getApplicationIcon(packageName);
                appIcon.setImageDrawable(icon);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }