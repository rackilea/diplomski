import android.support.v4.widget.SwipeRefreshLayout;
private SwipeRefreshLayout mswipeRefreshLayout;

mswipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

              //write your code here.
              //
                mswipeRefreshLayout.setRefreshing(false);
            }
        });