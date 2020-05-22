package com.infostream.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.infostream.models.Article;
import java.lang.String;

public interface ArticleRepositoryImpl extends PagingAndSortingRepository<Article, Long> {
    Page<Article> findAll(Pageable pageRequest);

    Page<Article> findByFeedId(String feedId, Pageable pageable);

    Page<Article> findByFeed_sourceId(String sourceId, Pageable pageable);
}