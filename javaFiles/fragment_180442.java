String key = String.valueOf(position) + c.getColumnName(j);
Float measuredWidth = mWidthCache.get(key);
if (width == null) {
    //Calculate measuredWidth
    mWidthCache.put(key, measuredWidth); //Then place back in cache
}

//Adjust width of layout based on measureWidth