<div class="list card" ng-repeat="video in videos | filter:searchBox" >
      <div class="item item-text-wrap">
        <h2>{{video.snippet.title}}</h2>
        <p><i class="ion ion-ios-calendar-outline"></i> {{video.snippet.publishedAt }}</p>
      </div>
      <div class="item item-image">
        <img ng-src="{{video.snippet.thumbnails.high.url}}" ng-show="!isvideoPlaying[video.id.videoId]" ng-click="displayvideo(video.id.videoId)"> 
        <!-- Use 'youtube-video' as an element or attribute. -->
        <div class="embed-responsive embed-responsive-16by9" ng-show="isvideoPlaying[video.id.videoId]">
          <youtube-video class="embed-responsive-item" video-id="video.id.videoId" player-vars="playerVars"></youtube-video>
        </div>
      </div>
    </div>