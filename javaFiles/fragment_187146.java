public boolean onDependentViewChanged(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        if(dependency instanceof SnackbarLayout) {
            this.updateFabTranslationForSnackbar(parent, child, dependency);
        } else if(dependency instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout)dependency;
            if(this.mTmpRect == null) {
                this.mTmpRect = new Rect();
            }

            Rect rect = this.mTmpRect;
            ViewGroupUtils.getDescendantRect(parent, dependency, rect);
            if(rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                if(!this.mIsAnimatingOut && child.getVisibility() == 0) {
                    this.animateOut(child);
                }
            } else if(child.getVisibility() != 0) {
                this.animateIn(child);
            }
        }
        return false;
    }